package bank.com.shared.annotations

import java.lang.annotation.Inherited

@Inherited
@Target(AnnotationTarget.CLASS)
annotation class Inject(vararg val tag: String)