package groovy


class RunntimeContext {
    String leadCode = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
    String check = "BBB"


    def create(String commandCode, String suffix) {
        return "$leadCode$commandCode$suffix$check"
    }

    def crcCode() {

    }
}
