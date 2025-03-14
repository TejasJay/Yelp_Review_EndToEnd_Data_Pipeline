# **🚀 Yelp Reviews Data Pipeline: End-to-End **

## **📌 Objective**

This project processes Yelp review data by **streaming JSON data using Flume**, **storing it in HDFS**, **transforming it in Hive**, and **exporting it to MySQL using Sqoop**.

* * *

## **🔹 Step 1: Environment Setup**

### **1️⃣ Install Required Software**

Make sure you have installed:

-   **Hadoop**
-   **Hive**
-   **Flume**
-   **Sqoop**
-   **MySQL**

### **1.1 Install Dependencies**

```bash
sudo apt update && sudo apt install -y openjdk-8-jdk mysql-server wget curl
```

### **1.2 Setup Hadoop & HDFS**

```bash
hdfs namenode -format
start-dfs.sh
start-yarn.sh
```

### **1.3 Start MySQL Server**

```bash
sudo systemctl start mysql
```

* * *

## **🔹 Step 2: Data Streaming with Flume**

### **2.1 Define Flume Configuration**

Create a file **`yelp_netcat_flume.conf`** with the following **Flume agent configuration**:

```ini
# Define the agent
agent.sources = netcat-source
agent.sinks = hdfs-sink
agent.channels = mem-channel

# Netcat Source (listens on port 44444)
agent.sources.netcat-source.type = netcat
agent.sources.netcat-source.bind = 0.0.0.0
agent.sources.netcat-source.port = 44444
agent.sources.netcat-source.channels = mem-channel

# Memory Channel
agent.channels.mem-channel.type = memory
agent.channels.mem-channel.capacity = 1000
agent.channels.mem-channel.transactionCapacity = 1000

# HDFS Sink (Stores JSON data in HDFS)
agent.sinks.hdfs-sink.type = hdfs
agent.sinks.hdfs-sink.hdfs.path = hdfs://localhost:9000/yelp_data/flume_review_json/
agent.sinks.hdfs-sink.hdfs.fileType = DataStream
agent.sinks.hdfs-sink.hdfs.writeFormat = Text
agent.sinks.hdfs-sink.hdfs.batchSize = 1000
agent.sinks.hdfs-sink.hdfs.rollSize = 0
agent.sinks.hdfs-sink.hdfs.rollCount = 0
agent.sinks.hdfs-sink.hdfs.idleTimeout = 0
agent.sinks.hdfs-sink.hdfs.filePrefix = yelp_reviews
agent.sinks.hdfs-sink.hdfs.useLocalTimeStamp = false

# Bind source, channel, and sink
agent.sinks.hdfs-sink.channel = mem-channel
agent.sources.netcat-source.channels = mem-channel
```

### **2.2 Start Flume Agent**

```bash
flume-ng agent -n agent -c conf -f yelp_netcat_flume.conf
```

* * *

## **🔹 Step 3: Data Ingestion Using Python**

Create **`send_to_nc.py`**, a Python script that streams Yelp data to Flume.

```python
import time
import socket

# Configuration
JSON_FILE = "/home/tejasjay94/yelp_prj/yelp_academic_dataset_review.json"
HOST = "localhost"
PORT = 44444

# Function to send data to Netcat
def send_data():
    with open(JSON_FILE, "r") as file:
        for line in file:
            try:
                # Open a socket connection to Netcat
                with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
                    s.connect((HOST, PORT))
                    s.sendall(line.encode() + b"\n")
                print(f"Sent: {line.strip()}")
                time.sleep(0.5)  # Simulating real-time streaming
            except Exception as e:
                print(f"Error sending data: {e}")

if __name__ == "__main__":
    send_data()
```

### **Run the Python Script**

```bash
python3 send_to_nc.py
```

* * *

## **🔹 Step 4: Hive Table Processing**

### **4.1 Create Hive Tables**

#### **JSON Table**

```sql
CREATE EXTERNAL TABLE IF NOT EXISTS yelp_reviews_json (
    review_id STRING,
    user_id STRING,
    business_id STRING,
    stars FLOAT,
    useful INT,
    funny INT,
    cool INT,
    text STRING,
    date_ STRING
)
ROW FORMAT SERDE 'org.apache.hive.hcatalog.data.JsonSerDe'
STORED AS TEXTFILE
LOCATION '/yelp_data/flume_review_json/';
```

#### **CSV Table**

```sql
CREATE EXTERNAL TABLE IF NOT EXISTS yelp_reviews_csv (
    review_id STRING,
    user_id STRING,
    business_id STRING,
    stars FLOAT,
    useful INT,
    funny INT,
    cool INT,
    text STRING,
    date_ STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/yelp_data/flume_csv/';
```

### **4.2 Convert JSON Data to CSV**

```sql
INSERT OVERWRITE TABLE yelp_reviews_csv
SELECT * FROM yelp_reviews_json;
```

* * *

## **🔹 Step 5: Automating Hive Processing**

Create a script **`process_hive_data.hql`**:

```sql
-- Create CSV table if not exists
CREATE EXTERNAL TABLE IF NOT EXISTS yelp_reviews_csv (
    review_id STRING,
    user_id STRING,
    business_id STRING,
    stars FLOAT,
    useful INT,
    funny INT,
    cool INT,
    text STRING,
    date_ STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/yelp_data/flume_csv/';

-- Insert JSON data into CSV table
INSERT OVERWRITE TABLE yelp_reviews_csv
SELECT * FROM yelp_reviews_json;
```

Create a shell script **`run_hive_process.sh`**:

```bash
#!/bin/bash

echo "Starting Hive data processing at $(date)"
hive -f /home/tejasjay94/yelp_prj/process_hive_data.hql
echo "Hive processing completed at $(date)"
```

### **Run the script**

```bash
bash run_hive_process.sh
```

* * *

## **🔹 Step 6: Export Data to MySQL using Sqoop**

### **6.1 Setup MySQL Database**

```sql
CREATE DATABASE yelp_db;
USE yelp_db;

CREATE TABLE yelp_reviews_csv (
    review_id VARCHAR(50) PRIMARY KEY,
    user_id VARCHAR(50),
    business_id VARCHAR(50),
    stars FLOAT,
    useful INT,
    funny INT,
    cool INT,
    text TEXT,
    date_ VARCHAR(50)
);
```

### **6.2 Automating Sqoop Export**

Create a script **`export_to_mysql.sh`**:

```bash
#!/bin/bash
while true; do
    echo "Starting Sqoop export..."
    sqoop export \
    --connect jdbc:mysql://localhost:3306/yelp_db \
    --username root --password 'MakeAmericaGreatAgain@123' \
    --table yelp_reviews_csv \
    --export-dir /yelp_data/flume_csv \
    --input-fields-terminated-by ',' \
    --lines-terminated-by '\n' \
    --num-mappers 1 \
    --update-key review_id \
    --update-mode allowinsert
    echo "Export complete. Waiting 5 minutes before next run..."
    sleep 300  # Wait for 5 minutes before running again
done
```

### **Run the script**

```bash
bash export_to_mysql.sh
```

* * *

## **🔹 Step 7: Automating the Entire Process**

To **run all components together**, create **`run_pipeline.sh`**:

```bash
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
```

### **Run the Full Pipeline**

```bash
bash run_pipeline.sh
```

* * *

## **📌 Summary**

| Step | Task |
| --- | --- |
| **Step 1** | Install Hadoop, Hive, Flume, Sqoop, MySQL |
| **Step 2** | Stream JSON Data to Flume |
| **Step 3** | Store Data in HDFS |
| **Step 4** | Process Data in Hive (Convert JSON to CSV) |
| **Step 5** | Automate Hive Processing |
| **Step 6** | Export Data to MySQL via Sqoop |
| **Step 7** | Automate the Entire Pipeline |

Now your **Yelp Reviews Data Pipeline** is fully **automated and scalable**! 🚀🎯
