cmd_Release/obj.target/addon/hola.o := g++ -o Release/obj.target/addon/hola.o ../hola.cc '-DNODE_GYP_MODULE_NAME=addon' '-DUSING_UV_SHARED=1' '-DUSING_V8_SHARED=1' '-DV8_DEPRECATION_WARNINGS=1' '-DV8_DEPRECATION_WARNINGS' '-DV8_IMMINENT_DEPRECATION_WARNINGS' '-D_GLIBCXX_USE_CXX11_ABI=1' '-D_LARGEFILE_SOURCE' '-D_FILE_OFFSET_BITS=64' '-D__STDC_FORMAT_MACROS' '-DOPENSSL_NO_PINSHARED' '-DOPENSSL_THREADS' '-DBUILDING_NODE_EXTENSION' -I/home/carvajal/.cache/node-gyp/18.16.0/include/node -I/home/carvajal/.cache/node-gyp/18.16.0/src -I/home/carvajal/.cache/node-gyp/18.16.0/deps/openssl/config -I/home/carvajal/.cache/node-gyp/18.16.0/deps/openssl/openssl/include -I/home/carvajal/.cache/node-gyp/18.16.0/deps/uv/include -I/home/carvajal/.cache/node-gyp/18.16.0/deps/zlib -I/home/carvajal/.cache/node-gyp/18.16.0/deps/v8/include  -fPIC -pthread -Wall -Wextra -Wno-unused-parameter -m64 -O3 -fno-omit-frame-pointer -fno-rtti -fno-exceptions -std=gnu++17 -MMD -MF ./Release/.deps/Release/obj.target/addon/hola.o.d.raw   -c
Release/obj.target/addon/hola.o: ../hola.cc \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/node.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/cppgc/common.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8config.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-array-buffer.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-local-handle.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-internal.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-version.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8config.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-object.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-maybe.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-persistent-handle.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-weak-callback-info.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-primitive.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-data.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-value.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-traced-handle.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-container.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-context.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-snapshot.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-date.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-debug.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-script.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-message.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-exception.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-extension.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-external.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-function.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-function-callback.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-template.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-memory-span.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-initialization.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-callbacks.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-isolate.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-embedder-heap.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-microtask.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-statistics.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-promise.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-unwinder.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-embedder-state-scope.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-platform.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-json.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-locker.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-microtask-queue.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-primitive-object.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-proxy.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-regexp.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-typed-array.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-value-serializer.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-wasm.h \
 /home/carvajal/.cache/node-gyp/18.16.0/include/node/node_version.h
../hola.cc:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/node.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/cppgc/common.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8config.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-array-buffer.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-local-handle.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-internal.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-version.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8config.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-object.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-maybe.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-persistent-handle.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-weak-callback-info.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-primitive.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-data.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-value.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-traced-handle.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-container.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-context.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-snapshot.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-date.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-debug.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-script.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-message.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-exception.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-extension.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-external.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-function.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-function-callback.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-template.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-memory-span.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-initialization.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-callbacks.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-isolate.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-embedder-heap.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-microtask.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-statistics.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-promise.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-unwinder.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-embedder-state-scope.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-platform.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-json.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-locker.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-microtask-queue.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-primitive-object.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-proxy.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-regexp.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-typed-array.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-value-serializer.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/v8-wasm.h:
/home/carvajal/.cache/node-gyp/18.16.0/include/node/node_version.h:
