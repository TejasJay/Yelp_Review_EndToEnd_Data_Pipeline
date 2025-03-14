#!/bin/bash

echo "Starting Hive data processing at $(date)"
hive -f /home/tejasjay94/yelp_prj/process_hive_data.hql
echo "Hive processing completed at $(date)"
