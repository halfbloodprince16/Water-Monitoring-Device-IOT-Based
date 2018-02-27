from pymongo import MongoClient
MONGODB_URI = "mongodb://vighnesh:allah@ds233218.mlab.com:33218/water"
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
    "user_id": "1",
    "t": "23"
}
pushRECORD(record)
record = getRECORD(1)
print(record);
