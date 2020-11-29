package com.sqkb.loadbanalcer;

import java.util.Iterator;
import java.util.Set;

/**
 * package: com.sqkb.loadbanalcer
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/29 下午9:34
 */
public class Candidate implements Iterable<Endpoint> {

    public final Set<Endpoint> endpoints;

    // 下游节点总权重
    public final int totalWeight;

    public Candidate(Set<Endpoint> endpoints) {
        int sum = 0;
        for (Endpoint endpoint : endpoints) {
            sum += endpoint.weight;
        }

        this.totalWeight = sum;
        this.endpoints = endpoints;
    }

    public int getEndpointCount() {
        return endpoints.size();
    }

    @Override
    public Iterator<Endpoint> iterator() {
        return ReadOnlyIterator.with(endpoints.iterator());
    }

    @Override
    public String toString() {
        return "Candidate [endpoints=" + endpoints + ", totalWeight=" + totalWeight + "]";
    }
}