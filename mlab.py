import os 
from pymongo import MongoClient

from flask import Flask, render_template
app = Flask(__name__)


MONGODB_URI = "mongodb://vighnesh:ganga@ds237700.mlab.com:37700/ganga"
client = MongoClient(MONGODB_URI, connectTimeoutMS=30000)
db = client.get_default_database()
user_records = db.user_records

# Return CPU temperature as a character string                                      
def getCPUtemperature():
    res = os.popen('vcgencmd measure_temp').readline()
    return(res.replace("temp=","").replace("'C\n",""))


def getRECORD(user_id):
    records = user_records.find_one({"user_id":user_id})
    return records

def pushRECORD(record):
    user_records.insert_one(record)


#x = getCPUtemperature();
#print(x)
#mlab part

record = {
    "user_id": 20,
    "t": 49.97,
    "ph": 7.2
}
pushRECORD(record)
#n = input("Enter till what ID Temperature Need to be displayed")
dic = {'1':00}
for i in range(1,21):
    record = getRECORD(i)
    rec = list(record.values())
    #print(rec[2])
    dic.update(record)
    #print(dic)

    

@app.route('/result')
def result():
   return render_template('result.html', result = dic)
if __name__ == '__main__':
   app.run(debug = True)