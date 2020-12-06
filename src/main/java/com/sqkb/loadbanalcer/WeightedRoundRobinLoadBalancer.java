package com.sqkb.loadbanalcer;

/**
 * package: com.sqkb.loadbanalcer
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/29 下午10:32
 */
public class WeightedRoundRobinLoadBalancer extends AbstractLoadBalancer {

    public WeightedRoundRobinLoadBalancer(Candidate candidate) {
        super(candidate);
    }

    public static LoadBalancer newInstance(Candidate candidate) throws Exception {
        WeightedRoundRobinLoadBalancer lb = new WeightedRoundRobinLoadBalancer(candidate);
        lb.init();
        return lb;
    }

    @Override
    public Endpoint nextEndpoint() {
        Endpoint selectedEndpoint = null;
        int subWeight = 0;
        int dynamicTotalWeight;
        final double rawRnd = super.random.nextDouble();
        int rand;
        final Candidate candidate = super.candidate;
        dynamicTotalWeight = candidate.totalWeight;

        for (Endpoint endpoint : candidate) {
            if (!endpoint.isOnLine()) {
                dynamicTotalWeight -= endpoint.weight;
                continue;
            }

            rand = (int) (rawRnd * dynamicTotalWeight);
            subWeight += endpoint.weight;
            if (rand <= subWeight) {
                selectedEndpoint = endpoint;
                break;
            }
        }

        return selectedEndpoint;
    }
}