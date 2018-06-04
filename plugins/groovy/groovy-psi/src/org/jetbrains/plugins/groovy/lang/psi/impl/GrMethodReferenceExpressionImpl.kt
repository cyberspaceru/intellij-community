// Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.plugins.groovy.lang.psi.impl

import com.intellij.lang.ASTNode
import org.jetbrains.plugins.groovy.lang.psi.api.GroovyResolveResult
import org.jetbrains.plugins.groovy.lang.psi.dataFlow.types.TypeInferenceHelper
import org.jetbrains.plugins.groovy.lang.psi.impl.statements.expressions.GrReferenceExpressionImpl
import org.jetbrains.plugins.groovy.lang.resolve.GrMethodReferenceResolver

class GrMethodReferenceExpressionImpl(node: ASTNode) : GrReferenceExpressionImpl(node) {

  override fun resolve(incomplete: Boolean): Collection<GroovyResolveResult> {
    return TypeInferenceHelper.getCurrentContext().resolve(this, incomplete, GrMethodReferenceResolver)
  }

  override fun hasMemberPointer(): Boolean = true

  override fun toString(): String = "Method reference expression"
}
