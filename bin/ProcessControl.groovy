/**
 *  脚本上下文
 */
class RuntimeContext {
    int pm1, pm2

    RuntimeContext(int pm1, int pm2) {
        this.pm1 = pm1
        this.pm2 = pm2
    }

    /**
     * 定义业务规则集
     */
    def businessRules = [
            'rule001': [
                    'TM001': pm1 >= 60000 ? 'A' : (pm1 >= 40000 && pm1 < 60000 ? 'B' : (pm1 >= 20000 && pm1 < 40000) ? 'C' : 'D'),
                    'TM002': pm2 >= 60000 ? 'A' : (pm2 >= 40000 && pm2 < 60000 ? 'B' : (pm2 >= 20000 && pm2 < 40000) ? 'C' : 'D')
            ],
            'rule002': [
                    'TM001': pm1 >= 60000 ? 'A' : (pm1 >= 40000 && pm1 < 60000 ? 'B' : (pm1 >= 20000 && pm1 < 40000) ? 'C' : 'D'),
                    'TM002': pm2 >= 60000 ? 'A' : (pm2 >= 40000 && pm2 < 60000 ? 'B' : (pm2 >= 20000 && pm2 < 40000) ? 'C' : 'D')
            ]
    ]

}

/**
 *
 * @param value 参数值
 * @param type 参数类型
 * @return
 */
def largeCompare(int pm1, int pm2) {
    def ctr = new RuntimeContext(pm1, pm2)
    def s1 = ctr.businessRules.rule001.TM001 + ctr.businessRules.rule001.TM002
    println s1
    return s1
}

/**
 * 默认遥测参数比判 接受计数加一
 * @param beforeValue
 * @param afterValue
 * @return
 */
def defaultTmCompare(int beforeValue, int afterValue) {
    if (beforeValue + 1 == afterValue) {
        return true;
    } else {
        return false;
    }
}