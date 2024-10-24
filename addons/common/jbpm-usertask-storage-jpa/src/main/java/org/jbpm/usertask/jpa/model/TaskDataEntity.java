/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jbpm.usertask.jpa.model;

import java.util.Objects;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class TaskDataEntity<T> {

    @Id
    @Column(name = "name")
    protected String name;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "task_id")
    protected UserTaskInstanceEntity taskInstance;

    @Column(name = "value")
    protected T value;

    @Column(name = "java_type")
    protected String javaType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserTaskInstanceEntity getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(UserTaskInstanceEntity taskInstance) {
        this.taskInstance = taskInstance;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TaskDataEntity<?> that = (TaskDataEntity<?>) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getTaskInstance(), that.getTaskInstance()) && Objects.equals(getValue(),
                that.getValue()) && Objects.equals(getJavaType(), that.getJavaType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTaskInstance(), getValue(), getJavaType());
    }
}
