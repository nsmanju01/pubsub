package com.google.pubsub.kafka.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twitter.finagle.stats.DefaultStatsReceiver;
import com.twitter.finagle.stats.StatsReceiver;


public class PubSubSourceTwitterStats {

  private static final Logger log = LoggerFactory.getLogger(PubSubSourceTwitterStats.class);

  private final StatsReceiver statsReceiver;


  public PubSubSourceTwitterStats() {
    this.statsReceiver = DefaultStatsReceiver.get().scope("pubsub-connector");
  }

  public void recordConsumeLatencyStat(Long latency) {
    statsReceiver.stat("streaming_subscriber_latency_millis").add(latency.floatValue());
  }

  public void recordEndToEndLatencyStat(Long latency) {
    statsReceiver.stat("streaming_subscriber_end_to_end_latency_millis").add(latency.floatValue());
  }
}
