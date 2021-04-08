/**
 * Copyright (c) 2012 Reficio (TM) - Reestablish your software! All Rights Reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//
// $Id$
//

import aQute.bnd.osgi.Jar
import org.reficio.p2.utils.TestUtils as Util;

// verify target
File target = new File(basedir, 'target/repository/plugins')
assert target.exists()
assert target.listFiles().size() == 3

// verify number of artifacts
def files = target.listFiles().collect { it.name }
assert files.size() == 3

// verify binary artifact
String jarName = "org.mockito.mockito-core_1.9.0.jar"
assert files.contains(jarName)

Jar jar = new Jar(new File(target, jarName));
assert Util.symbolicName(jar) == "org.mockito.mockito-core"
assert Util.version(jar) == "1.9.0"

// verify 'hamcrest' dependency artifact
String hamcrestName = "org.hamcrest.core_1.1.0.jar"
assert files.contains(hamcrestName)

Jar hamcrestJar = new Jar(new File(target, hamcrestName));
assert Util.symbolicName(hamcrestJar) == "org.hamcrest.core"
assert Util.version(hamcrestJar) == "1.1.0"
assert Util.hasNoBndLastModifiedHeader(hamcrestJar)

// verify 'objenesis' dependency artifact
String objenesisName = "org.objenesis_1.0.0.jar"
assert files.contains(objenesisName)

Jar objenesisJar = new Jar(new File(target, objenesisName));
assert Util.symbolicName(objenesisJar) == "org.objenesis"
assert Util.version(objenesisJar) == "1.0.0"