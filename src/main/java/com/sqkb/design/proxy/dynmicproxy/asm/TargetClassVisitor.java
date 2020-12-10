package com.sqkb.design.proxy.dynmicproxy.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.sqkb.design.proxy.dynmicproxy.asm
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/10 上午11:03
 * <p>
 * 读取目标类的字节码, 保存方法相关的数据
 */
public class TargetClassVisitor extends ClassVisitor {

    private boolean isFinal;

    private List<MethodBean> methods = new ArrayList<>();

    private List<MethodBean> declaredMethods = new ArrayList<>();

    private List<MethodBean> constructors = new ArrayList<>();

    public TargetClassVisitor() {
        super(AsmProxyFactory.ASM_VERSION);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        if ((access & Opcodes.ACC_FINAL) == Opcodes.ACC_FINAL) {
            isFinal = true;
        }

        if (superName != null) {
            List<MethodBean> beans = initMethodBeanByParent(superName);
            if (beans != null && !beans.isEmpty()) {
                for (MethodBean bean : beans) {
                    if (!methods.contains(bean)) {
                        methods.add(bean);
                    }
                }
            }
        }
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String description, String signature, String[] exceptions) {
        if ("<init>".equals(name)) {
            MethodBean constructor = new MethodBean(access, name, description);
            constructors.add(constructor);
        } else if (!"<clinit>".equals(name)) {
            if ((access & Opcodes.ACC_FINAL) == Opcodes.ACC_FINAL || (access & Opcodes.ACC_STATIC) == Opcodes.ACC_STATIC) {
                return super.visitMethod(access, name, description, signature, exceptions);
            }

            MethodBean methodBean = new MethodBean(access, name, description);
            declaredMethods.add(methodBean);
            if ((access & Opcodes.ACC_PUBLIC) == Opcodes.ACC_PUBLIC) {
                methods.add(methodBean);
            }
        }
        return super.visitMethod(access, name, description, signature, exceptions);
    }

    public boolean isFinal() {
        return isFinal;
    }

    public List<MethodBean> getMethods() {
        return methods;
    }

    public List<MethodBean> getDeclaredMethods() {
        return declaredMethods;
    }

    public List<MethodBean> getConstructors() {
        return constructors;
    }

    public static class MethodBean {
        public int access;
        public String methodName;
        public String methodDesc;

        public MethodBean() {
        }

        public MethodBean(int access, String methodName, String methodDesc) {
            this.access = access;
            this.methodName = methodName;
            this.methodDesc = methodDesc;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (!(obj instanceof MethodBean)) {
                return false;
            }

            MethodBean bean = (MethodBean) obj;
            return access == bean.access && methodName != null && bean.methodName != null && methodName.equals(bean.methodName) && methodDesc != null && bean.methodDesc != null && methodDesc.equals(bean.methodDesc);
        }
    }

    private List<MethodBean> initMethodBeanByParent(String superName) {

        try {
            if (superName != null && !superName.isEmpty()) {
                ClassReader classReader = new ClassReader(superName);
                TargetClassVisitor visitor = new TargetClassVisitor();
                classReader.accept(visitor, ClassReader.SKIP_DEBUG);
                List<MethodBean> beans = new ArrayList<>();

                for (MethodBean methodBean : visitor.methods) {
                    if ((methodBean.access & Opcodes.ACC_FINAL) == Opcodes.ACC_FINAL || (methodBean.access & Opcodes.ACC_STATIC) == Opcodes.ACC_STATIC) {
                        continue;
                    }

                    if ((methodBean.access & Opcodes.ACC_PUBLIC) == Opcodes.ACC_PUBLIC) {
                        beans.add(methodBean);
                    }
                }

                return beans;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}