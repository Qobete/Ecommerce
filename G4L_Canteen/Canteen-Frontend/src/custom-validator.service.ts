import { ValidationErrors, ValidatorFn, AbstractControl } from '@angular/forms';

export class CustomValidatorService {

  static patternValidator(regex: RegExp, error: ValidationErrors): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } => {
        if (!control.value) {
            return null;
        }
        const valid = regex.test(control.value);
        return valid ? null : error;
    };
}
}
