//snippet-sourcedescription:[StartStopInstance.java demonstrates how to start and stop an EC2 instance]
//snippet-keyword:[SDK for Java 2.0]
//snippet-keyword:[Code Sample]
//snippet-service:[ec2]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[11/02/2020]
//snippet-sourceauthor:[scmacdon]
/*
 * Copyright 2010-2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.example.ec2;
// snippet-start:[ec2.java2.start_stop_instance.complete]
// snippet-start:[ec2.java2.start_stop_instance.import]
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.StartInstancesRequest;
import software.amazon.awssdk.services.ec2.model.StopInstancesRequest;

// snippet-end:[ec2.java2.start_stop_instance.import]
/**
 * Starts or stops an EC2 instance
 */
public class StartStopInstance {
    public static void main(String[] args) {
        final String USAGE =
                "To run this example, supply an instance id and start or stop\n" +
                        "Ex: StartStopInstance <instance-id> <start|stop>\n";

        if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String instanceId = args[0];

        boolean start;

        if(args[1].equals("start")) {
            start = true;
        } else {
            start = false;
        }

        if(start) {
            startInstance(instanceId);
        } else {
            stopInstance(instanceId);
        }
    }

    public static void startInstance(String instanceId) {
        // snippet-start:[ec2.java2.start_stop_instance.start]
        Ec2Client ec2 = Ec2Client.create();

        StartInstancesRequest request = StartInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        ec2.startInstances(request);

        // snippet-end:[ec2.java2.start_stop_instance.start]
        System.out.printf("Successfully started instance %s", instanceId);
    }

    public static void stopInstance(String instanceId) {
        // snippet-start:[ec2.java2.start_stop_instance.stop]
        Ec2Client ec2 = Ec2Client.create();

        StopInstancesRequest request = StopInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        ec2.stopInstances(request);

        // snippet-end:[ec2.java2.start_stop_instance.stop]
        System.out.printf("Successfully stop instance %s", instanceId);
    }
}
// snippet-end:[ec2.java2.start_stop_instance.complete]
