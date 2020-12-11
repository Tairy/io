package com.sqkb.annotation;

/**
 * package: com.sqkb.annotation
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/11 下午3:42
 */
public class Main {

    @CustomAnnotation(name = "world")
    public static void sayHello(final String name) {
        System.out.println("Hello " + name);
    }

    @CustomAnnotation
    public static void sayDefault(final String name) {
        System.out.println("Hello " + name);
    }

    public static void main(String[] args) {
        final CustomAnnotationProcessor customAnnotationProcessor = new CustomAnnotationProcessor();
        try {
            customAnnotationProcessor.parseMethod(Main.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}