
class RunTimeContext {
    def helloWithoutParam() {
        println "start to call helloWithoutParam!"
        return "success, helloWithoutParam";
    }

    def helloWithParam(person, id) {
        Random random = new Random()
        return "success, helloWithParam " + "随机数为" + random.nextInt(1000000);
    }
}