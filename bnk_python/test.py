from flask import Flask
app = Flask(__name__)

@app.route("/")
def hello():
    return "<h1>Hello World!</h1>"

@app.route("/fromspring")
def data():
    return "frompythonserver"

@app.route("/intspring")
def intdata():
    return 5000


if __name__ == "__main__":
    app.run()