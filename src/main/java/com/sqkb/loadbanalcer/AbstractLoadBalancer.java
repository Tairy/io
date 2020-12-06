package com.sqkb.loadbanalcer;

import java.util.Random;

/**
 * package: com.sqkb.loadbanalcer
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/29 下午10:00
 */
public abstract class AbstractLoadBalancer implements LoadBalancer {

    protected volatile Candidate candidate;

    protected final Random random;

    private Thread heartBeatThread;

    public AbstractLoadBalancer(Candidate candidate) {
        if (null == candidate || 0 == candidate.getEndpointCount()) {
            throw new IllegalArgumentException("Invalid candidate " + candidate);
        }
        this.candidate = candidate;
        random = new Random();
    }

    public synchronized void init() throws Exception {
        if (null == heartBeatThread) {
            heartBeatThread = new Thread(new HeartBeatTask(), "LB_Heartbeat");
            heartBeatThread.setDaemon(true);
            heartBeatThread.start();
        }
    }

    @Override
    public void updateCandidate(final Candidate candidate) {
        if (null == candidate || 0 == candidate.getEndpointCount()) {
            throw new IllegalArgumentException("Invalid candidate " + candidate);
        }
        this.candidate = candidate;
    }

    @Override
    public abstract Endpoint nextEndpoint();

    protected void monitorEndpoints() {
        final Candidate currCandidate = candidate;
        boolean isTheEndpointOnline;

        for (Endpoint endpoint : currCandidate) {
            isTheEndpointOnline = endpoint.isOnLine();
            if (doDetect(endpoint) != isTheEndpointOnline) {
                endpoint.setOnLine(!isTheEndpointOnline);
                if (isTheEndpointOnline) {
                    System.out.println(endpoint + "offline.");
                } else {
                    System.out.println(endpoint + "is online now.");
                }
            }
        }
    }

    private boolean doDetect(Endpoint endpoint) {
        boolean online = true;
        int rand = random.nextInt(1000);
        if (rand <= 500) {
            online = false;
        }
        return online;
    }

    private class HeartBeatTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    monitorEndpoints();
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {

            }
        }
    }
}