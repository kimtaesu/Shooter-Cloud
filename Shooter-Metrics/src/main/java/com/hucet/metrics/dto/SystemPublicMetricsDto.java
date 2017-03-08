package com.hucet.metrics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SystemPublicMetricsDto implements Serializable {
    private long mem;
    @JsonProperty("mem.free")
    private long mem_free;
    private int processors;
    //    Instance status up 시간
    @JsonProperty("instance.uptime")
    private long instance_uptime;
    //    Health status up 시간
    private long uptime;
    //    ??
    @JsonProperty("systemload.average")
    private int systemload_average;
    @JsonProperty("heap.committed")
    private long heap_committed;
    @JsonProperty("heap.init")
    private long heap_init;
    @JsonProperty("heap.used")
    private long heap_used;

    private long heap;

    @JsonProperty("nonheap.committed")
    private long nonheap_committed;
    @JsonProperty("nonheap.init")
    private long nonheap_init;
    @JsonProperty("nonheap.used")
    private long nonheap_used;
    private long nonheap;
    @JsonProperty("threads.peak")
    private int threads_peak;
    @JsonProperty("threads.daemon")
    private int threads_daemon;
    @JsonProperty("threads.totalStarted")
    private int threads_totalStarted;
    private int threads;

    private long classes;
    @JsonProperty("classes.loaded")
    private long classes_loaded;
    @JsonProperty("classes.unloaded")
    private long classes_unloaded;

    @JsonProperty("gc.ps_scavenge.count")
    private long gc_ps_scavenge_count;
    @JsonProperty("gc.ps_scavenge.time")
    private long gc_ps_scavenge_time;
    @JsonProperty("gc.ps_marksweep.count")
    private long gc_ps_marksweep_count;
    @JsonProperty("gc.ps_marksweep.time")
    private long gc_ps_marksweep_time;

    @JsonProperty("normalized.servo.restclient.totaltime")
    private long normalized_servo_restclient_totaltime;


    @JsonProperty("gauge.servo.restclient.max")
    private long gauge_servo_restclient_max;

    @JsonProperty("gauge.servo.restclient.min")
    private long gauge_servo_restclient_min;

    @JsonProperty("gauge.servo.response.metrics")
    private long gauge_servo_response_metrics;
    @JsonProperty("normalized.servo.restclient.count")
    private long normalized_servo_restclient_count;

    @JsonProperty("counter.servo.eurekaclient.transport.request")
    private long counter_servo_eurekaclient_transport_request;
    @JsonProperty("normalized.servo.eurekaclient.transport.latency.totaltime")
    private long normalized_servo_eurekaclient_transport_latency_totaltime;
    @JsonProperty("normalized.servo.eurekaclient.transport.latency.count")
    private long normalized_servo_eurekaclient_transport_latency_count;
    @JsonProperty("gauge.servo.eurekaclient.transport.latency.min")
    private long gauge_servo_eurekaclient_transport_latency_min;
    @JsonProperty("gauge.servo.eurekaclient.transport.latency.max")
    private long gauge_servo_eurekaclient_transport_latency_max;

    @JsonProperty("gauge.servo.eurekaclient.registry.lastupdatesec_00240")
    private long gauge_servo_eurekaclient_registry_lastupdatesec_00240;
    @JsonProperty("counter.servo.eurekaclient.transport.connectionerrors")
    private long counter_servo_eurekaclient_transport_connectionerrors;
    @JsonProperty("gauge.servo.eurekaclient.registration.lastheartbeatsec_00030")
    private long gauge_servo_eurekaclient_registration_lastheartbeatsec_00030;

    @JsonProperty("counter.servo.discoveryclient-httpclient_reuse")
    private long counter_servo_discoveryclient_httpclient_reuse;
    @JsonProperty("counter.servo.discoveryclient-httpclient_createnew")
    private long counter_servo_discoveryclient_httpclient_createnew;
    @JsonProperty("counter.servo.discoveryclient-httpclient_request")
    private long counter_servo_discoveryclient_httpclient_request;
    @JsonProperty("counter.servo.discoveryclient-httpclient_release")
    private long counter_servo_discoveryclient_httpclient_release;
    @JsonProperty("counter.servo.discoveryclient-httpclient_delete")
    private long counter_servo_discoveryclient_httpclient_delete;


    @JsonProperty("normalized.servo.discoveryclient-httpclient_requestconnectiontimer.totaltime")
    private long normalized_servo_discoveryclient_httpclient_requestconnectiontimer_totaltime;
    @JsonProperty("normalized.servo.discoveryclient-httpclient_requestconnectiontimer.count")
    private long normalized_servo_discoveryclient_httpclient_requestconnectiontimer_count;
    @JsonProperty("gauge.servo.discoveryclient-httpclient_requestconnectiontimer.min")
    private long gauge_servo_discoveryclient_httpclient_requestconnectiontimer_min;
    @JsonProperty("gauge.servo.discoveryclient-httpclient_requestconnectiontimer.max")
    private long gauge_servo_discoveryclient_httpclient_requestconnectiontimer_max;
    @JsonProperty("normalized.servo.discoveryclient-httpclient_createconnectiontimer.totaltime")
    private long normalized_servo_discoveryclient_httpclient_createconnectiontimer_totaltime;
    @JsonProperty("normalized.servo.discoveryclient-httpclient_createconnectiontimer.count")
    private long normalized_servo_discoveryclient_httpclient_createconnectiontimer_count;
    @JsonProperty("gauge.servo.discoveryclient-httpclient_createconnectiontimer.min")
    private long gauge_servo_discoveryclient_httpclient_createconnectiontimer_min;
    @JsonProperty("gauge.servo.discoveryclient-httpclient_createconnectiontimer.max")
    private long gauge_servo_discoveryclient_httpclient_createconnectiontimer_max;
    
    @JsonProperty("gauge.servo.connectioncount")
    private long gauge_servo_connectioncount;
    @JsonProperty("gauge.servo.eurekaclient.registration.lastheartbeatsec_00480")
    private long gauge_servo_eurekaclient_registration_lastheartbeatsec_00480;
    @JsonProperty("normalized.servo.eureka-connection-cleaner-time.totaltime")
    private long normalized_servo_eureka_connection_cleaner_time_totaltime;
    @JsonProperty("normalized.servo.eureka-connection-cleaner-time.count")
    private long normalized_servo_eureka_connection_cleaner_time_count;
    @JsonProperty("gauge.servo.eureka-connection-cleaner-time.min")
    private long gauge_servo_eureka_connection_cleaner_time_min;
    @JsonProperty("gauge.servo.eureka-connection-cleaner-time.max")
    private long gauge_servo_eureka_connection_cleaner_time_max;

    @JsonProperty("counter.servo.eureka-connection-cleaner-failure")
    private long counter_servo_eureka_connection_cleaner_failure;


    @JsonProperty("gauge.servo.eurekaclient.transport.quarantinesize")
    private long gauge_servo_eurekaclient_transport_quarantinesize;
    @JsonProperty("gauge.servo.eurekaclient.registry.lastupdatesec_00060")
    private long gauge_servo_eurekaclient_registry_lastupdatesec_00060;
    @JsonProperty("gauge.servo.eurekaclient.registration.lastheartbeatsec_00060")
    private long gauge_servo_eurekaclient_registration_lastheartbeatsec_00060;
    @JsonProperty("gauge.servo.eurekaclient.registry.lastupdatesec_00030")
    private long gauge_servo_eurekaclient_registry_lastupdatesec_00030;
    @JsonProperty("gauge.servo.eurekaclient.registry.lastupdatesec_00015")
    private long gauge_servo_eurekaclient_registry_lastupdatesec_00015;
    @JsonProperty("gauge.servo.eurekaclient.registration.lastheartbeatsec_00015")
    private long gauge_servo_eurekaclient_registration_lastheartbeatsec_00015;
    @JsonProperty("gauge.servo.eurekaclient.registry.lastupdatesec_00120")
    private long gauge_servo_eurekaclient_registry_lastupdatesec_00120;
    @JsonProperty("gauge.servo.eurekaclient.registration.lastheartbeatsec_00120")
    private long gauge_servo_eurekaclient_registration_lastheartbeatsec_00120;

    @JsonProperty("counter.servo.timeouts")
    private long counter_servo_timeouts;
    @JsonProperty("counter.servo.rejectedexecutions")
    private long counter_servo_rejectedexecutions;
    @JsonProperty("counter.servo.throwables")
    private long counter_servo_throwables;

    @JsonProperty("gauge.servo.threadpoolused")
    private long gauge_servo_threadpoolused;

    @JsonProperty("gauge.servo.eurekaclient.registry.lastupdatesec_00480")
    private long gauge_servo_eurekaclient_registry_lastupdatesec_00480;
    @JsonProperty("gauge.servo.eurekaclient.resolver.endpointssize")
    private long gauge_servo_eurekaclient_resolver_endpointssize;
    @JsonProperty("gauge.servo.eurekaclient.resolver.lastloadtimestamp")
    private long gauge_servo_eurekaclient_resolver_lastloadtimestamp;
    @JsonProperty("counter.servo.discoveryclient_reconcilehashcodemismatch")
    private long counter_servo_discoveryclient_reconcilehashcodemismatch;
    @JsonProperty("normalized.servo.discoveryclient_fetchregistry.totaltime")
    private long normalized_servo_discoveryclient_fetchregistry_totaltime;
    @JsonProperty("normalized.servo.discoveryclient_fetchregistry.count")
    private long normalized_servo_discoveryclient_fetchregistry_count;
    @JsonProperty("gauge.servo.discoveryclient_fetchregistry.min")
    private long gauge_servo_discoveryclient_fetchregistry_min;
    @JsonProperty("gauge.servo.discoveryclient_fetchregistry.max")
    private long gauge_servo_discoveryclient_fetchregistry_max;
    @JsonProperty("counter.servo.discoveryclient_reregister")
    private long counter_servo_discoveryclient_reregister;
    @JsonProperty("gauge.servo.eurekaclient.registry.localregistrysize")
    private long gauge_servo_eurekaclient_registry_localregistrysize;
    @JsonProperty("gauge.servo.eurekaclient.registry.lastsuccessfulregistryfetchtimeperiod")
    private long gauge_servo_eurekaclient_registry_lastsuccessfulregistryfetchtimeperiod;
    @JsonProperty("gauge.servo.eurekaclient.registration.lastsuccessfulheartbeattimeperiod")
    private long gauge_servo_eurekaclient_registry_lastsuccessfulheartbeattimeperiod;
    @JsonProperty("gauge.servo.eurekaclient.transport.currentsessionduration")
    private long gauge_servo_eurekaclient_transport_currentsessionduration;
    @JsonProperty("gauge.servo.eurekaclient.registration.lastheartbeatsec_00240")
    private long gauge_servo_eurekaclient_registration_lastheartbeatsec_00240;
    @JsonProperty("httpsessions.max")
    private long httpsessions_max;
    @JsonProperty("httpsessions.active")
    private long httpsessions_active;


}
