package uz.elmurodov.utils.validators;

import uz.elmurodov.utils.BaseUtils;

public abstract class AbstractValidator {
    protected final BaseUtils utils;

    protected AbstractValidator(BaseUtils utils) {
        this.utils = utils;
    }
}
