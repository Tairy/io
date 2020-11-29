package com.sqkb.loadbanalcer;

/**
 * package: com.sqkb.loadbanalcer
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/29 下午9:29
 */
public class ServiceInvoker {

    private static final ServiceInvoker INSTANCE = new ServiceInvoker();

    private volatile LoadBalancer loadBalancer;

    private ServiceInvoker() {
    }

    public static ServiceInvoker getInstance() {
        return INSTANCE;
    }

    public void dispatchRequest(Request request) {
        Endpoint endpoint = getLoadBalancer().nextEndpoint();

        if (null == endpoint) {
            return;
        }

        dispatchToDownStream(request, endpoint);
    }

    public LoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    public void setLoadBalancer(LoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    public void dispatchToDownStream(Request request, Endpoint endpoint) {
        System.out.println("Dispatch request to " + endpoint + ":" + request);
    }
}