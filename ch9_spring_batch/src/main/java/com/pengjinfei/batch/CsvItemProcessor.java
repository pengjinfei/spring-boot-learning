package com.pengjinfei.batch;

import com.pengjinfei.domain.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * Created by Pengjinfei on 16/9/12.
 * Description:
 */
public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

    @Override
    public Person process(Person item) throws ValidationException {
        super.process(item);

        if (item.getNation().equals("汉族")) {
            item.setNation("01");
        } else {
            item.setNation("02");
        }

        return item;
    }
}
