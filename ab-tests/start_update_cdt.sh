#!/bin/bash

#-n: Number of requests
#-c: Number of concurrent requests
#-H: Add header
#—r: flag to not exit on socket receive errors
#-k: Use HTTP KeepAlive feature
#-p: File containing data to POST
#-T: Content-type header to use for POST/PUT data,

#ab -n 10000 -c 10 -u post_cdt.txt -T application/json http://192.168.1.235:8080/api/conduit

ab -n 10000 -c 10 -u post_cdt.txt -T application/json http://192.168.1.89:8080/api/conduit