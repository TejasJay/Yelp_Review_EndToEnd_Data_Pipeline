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
