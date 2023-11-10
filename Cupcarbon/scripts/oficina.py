#Subscriber

import time
topic = "ruta-5/"
node.subscribe(topic)

def callback(topic, message):
	node.mark(message)

while node.loop():
	time.sleep(1)