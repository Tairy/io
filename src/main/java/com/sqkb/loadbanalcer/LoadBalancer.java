package com.sqkb.loadbanalcer;

/**
 * package: com.sqkb.loadbanalcer
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/29 下午9:33
 */
public interface LoadBalancer {

    void updateCandidate(final Candidate candidate);

    Endpoint nextEndpoint();
}