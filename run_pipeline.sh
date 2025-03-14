#!/bin/bash

# Start Flume
echo "Starting Flume..."
flume-ng agent -n agent -c conf -f yelp_netcat_flume.conf &

# Start Data Streaming
echo "Starting Python data stream..."
python3 send_to_nc.py &

# Process Data in Hive
echo "Processing data in Hive..."
bash run_hive_process.sh

# Export to MySQL
echo "Exporting data to MySQL..."
bash export_to_mysql.sh
