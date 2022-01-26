package uz.elmurodov.utils.validators;

import uz.elmurodov.utils.BaseUtils;
import uz.jl.utils.BaseUtil;

public abstract class AbstractValidator {
    protected final BaseUtils utils;

    protected AbstractValidator(BaseUtils utils) {
        this.utils = utils;
    }
}
