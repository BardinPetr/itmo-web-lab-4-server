package ru.bardinpetr.itmo.web.lab4.constraints.validator.range

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.springframework.beans.BeansException
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.ApplicationContext
import ru.bardinpetr.itmo.web.lab4.constraints.models.DoubleRange

class DoubleRangeValidator(
    private val ctx: ApplicationContext
) : ConstraintValidator<InDoubleRange, Double> {

    private var range: DoubleRange? = null

    override fun initialize(constraintAnnotation: InDoubleRange) {
        super.initialize(constraintAnnotation)

        try {
            range = ctx.getBean(constraintAnnotation.rangeBean) as DoubleRange
        } catch (_: NoSuchBeanDefinitionException) {
        } catch (_: BeansException) {
        }
    }

    override fun isValid(value: Double?, context: ConstraintValidatorContext?): Boolean {
        if (value == null)
            return false

        range?.let {
            val minCheck = value.compareTo(it.min)
            val maxCheck = value.compareTo(it.max)
            return (if (it.maxInclusive) minCheck >= 0 else minCheck > 0) &&
                    (if (it.maxInclusive) maxCheck <= 0 else maxCheck < 0)
        }
        return false
    }

}