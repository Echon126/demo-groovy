package groovy

import java.util.Random

def helloWithoutParam() {
    println "start to call helloWithoutParam!"
    return "success, helloWithoutParam";
}

def helloWithParam(person, id) {
    println "start to call helloWithParam, param{person:" + person + ", id:" + id + "}";
    Random random = new Random()
    return "success, helloWithParam" + random.nextInt(100);
}