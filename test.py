import os 
from pymongo import MongoClient
MONGODB_URI = "mongodb://vighnesh:allah@ds233218.mlab.com:33218/water"
# Return CPU temperature as a character string                                      
def getCPUtemperature():
    res = os.popen('vcgencmd measure_temp').readline()
    return(res.replace("temp=","").replace("'C\n",""))

x = getCPUtemperature();
print(x)
#mlab part
client = MongoClient(MONGODB_URI, connectTimeoutMS=30000)
db = client.get_default_database()
user_records = db.user_records

def getRECORD(user_id):
    records = user_records.find_one({"user_id":user_id})
    return records

def pushRECORD(record):
    user_records.insert_one(record)

def updateRecord(record, updates):
    user_records.update_one({'_id': record['_id']},{'$set': updates}, upsert=False)


record = {
    "user_id": 16,
    "t": x
}
pushRECORD(record)
n = input("Enter till what ID Temperature Need to be displayed")
for i in range(1,n+1):
	record = getRECORD(i)
	print(record);
