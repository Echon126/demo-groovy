package com.example.demo.workflow.chain;

import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.config.ConfigParser;
import org.apache.commons.chain.impl.CatalogFactoryBase;
import org.apache.commons.chain.impl.ContextBase;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestCommand {
    private static final String CONFIG_FILE = "/groovy/catalog.xml";

    private ConfigParser parser;

    private Catalog catalog;

    public TestCommand() {
        //parser = new ConfigParser();
    }


    @PostConstruct
    public void inti() throws Exception {
        parser = new ConfigParser();
        if (catalog == null) {
            parser.parse(this.getClass().getResource(CONFIG_FILE));
        }
        catalog = CatalogFactoryBase.getInstance().getCatalog();
    }


   /* public static void main(String[] args) throws Exception {
        TestCommand loader = new TestCommand();
        Catalog catalog = loader.getCatalog();
        Context context = new ContextBase();
       // context.put("isHoliday",true);
        Command Command = catalog.getCommand("life-work");
        boolean execute = Command.execute(context);
        System.out.println(execute);

    }*/

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
