from flask import Flask, request
import json

app = Flask(__name__)

@app.route("/")
def hello():
    return "<h1>Hello World!</h1>"

@app.route("/tospring")
def data():
    return "frompythonserver"

@app.route("/fromspring", methods=['POST'])
def intdata():
    user = request.form['1101']
    print(request.form['1101'])
    user_json = json.loads(user)
    
    # 1101이라는 key ( user정보에 )
    # 거제4동 815-59번지라는 정보가 저장되어 있음

    # 위 user data를 보고 판별해서....
    # 모델에 적용한 다음이

    # 아래에 리턴해주면 됌.

    return user_json['userAddress']


if __name__ == "__main__":
    app.run()