package com.github.jntakpe.skillmatcher.service;

import com.github.jntakpe.skillmatcher.domain.Competence;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jntakpe
 */
public class CompetenceServiceTest extends AbstractServiceTestContext {

    public static final String COMP_TABLE = "competence";

    public static final String JAVAEE = "JavaEE";

    @Autowired
    private CompetenceService competenceService;

    public static Operation compOperations() {
        return sequenceOf(
                Operations.deleteAllFrom(COMP_TABLE),
                Operations.insertInto(COMP_TABLE)
                        .columns("nom")
                        .values(JAVAEE)
                        .values("Spring")
                        .build()
        );
    }

    @Override
    protected String getTable() {
        return COMP_TABLE;
    }

    @Override
    protected Operation operations() {
        return compOperations();
    }

    @Test
    public void findAll_shouldFindSome() {
        Competence javaEE = new Competence();
        javaEE.setNom(JAVAEE);
        assertThat(competenceService.findAll()).isNotNull().isNotEmpty().contains(javaEE);
    }
}
