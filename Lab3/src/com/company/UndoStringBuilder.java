package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class UndoStringBuilder {
    public interface Action{
        void exec();
        void undo();
    }

    private StringBuilder stringBuilder;
    public Stack <Action> actions = new Stack<>();

    private UndoStringBuilder() {
        stringBuilder = new StringBuilder();
    }
    private UndoStringBuilder(CharSequence seq) {
        stringBuilder = new StringBuilder(seq);
    }
    private UndoStringBuilder(int capacity) {
        stringBuilder = new StringBuilder(capacity);
    }
    UndoStringBuilder(String str) {
        stringBuilder = new StringBuilder(str);
    }
    public String toString() {
        return stringBuilder.toString();
    }

    public UndoStringBuilder appendString(String str) {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(str);
            }

            @Override
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length() - str.length() - 1,
                        stringBuilder.length());
            }
        };


        actions.add(action);
        action.exec();
        return this;
    }
    public UndoStringBuilder appendBoolean(boolean b)
    {
        String appended = String.valueOf(b);

        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(b);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };
        
        action.exec();
        actions.push(action);

        return this;
    }

    public UndoStringBuilder appendChar(char c)
    {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(c);
            }

            @Override
            public void undo() {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    public UndoStringBuilder appendCharArray(char[] str)
    {
        String appended = String.valueOf(str);

        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(str);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    public UndoStringBuilder appendCharWithOffset(char[] str, int offset, int len)
    {
        String appended = String.valueOf(str).substring(offset,offset + len);

        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(str, offset, len);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    public UndoStringBuilder appendCharSequence(CharSequence s)
    {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(s);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - s.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    public UndoStringBuilder appendCharSequenceFromTo(CharSequence s, int start, int end)
    {
        String appended = String.valueOf(s).substring(start, end);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(s, start, end);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    public UndoStringBuilder appendDouble(double d)
    {
        String appended = String.valueOf(d);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(d);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    public UndoStringBuilder appendINT(int i)
    {
        String appended = String.valueOf(i);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(i);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    public UndoStringBuilder appendLong(long lng)
    {
        String appended = String.valueOf(lng);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(lng);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);
        return this;
    }
    public UndoStringBuilder appendObject(Object o)
    {
        String appended = String.valueOf(o);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(o);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);
        return this;
    }
    public UndoStringBuilder appendStringBuffer(StringBuffer sb)
    {
        String appended = String.valueOf(sb);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(sb);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);
        return this;
    }

    public UndoStringBuilder delete(int start, int end) {
        String deleted = stringBuilder.substring(start, end);

        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.delete(start, end);
            }

            @Override
            public void undo() {
                stringBuilder.insert(start, deleted);
            }
        };

        action.exec();
        actions.add(action);
        return this;
    }

    public UndoStringBuilder deleteCharAt(int index) {
        char deleted = stringBuilder.charAt(index);
        ;
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.deleteCharAt(index);
            }

            @Override
            public void undo() {
                stringBuilder.insert(index, deleted);
            }
        };

        action.exec();
        actions.add(action);
        return this;
    }

    public UndoStringBuilder replace(int start, int end, String str) {
        String deleted = stringBuilder.substring(start, end);

        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.replace(start, end, str);;
            }

            @Override
            public void undo() {
                stringBuilder.replace(start, end, deleted);
            }
        };

        action.exec();
        actions.add(action);
        return this;
    }

    public UndoStringBuilder insertCharArray(int index, char[] str, int offset, int len) {
        String inserted = String.valueOf(str).substring(offset, offset + len);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.insert(index, str, offset, len);
            }

            @Override
            public void undo() {
                stringBuilder.delete(offset, offset + inserted.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }

    public UndoStringBuilder insertString(int offset, String str) {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.insert(offset, str);
            }

            @Override
            public void undo() {
                stringBuilder.delete(offset, offset + str.length());
            }
        };

        action.exec();
        actions.push(action);
        ;
        return this;
    }
    public UndoStringBuilder insertBoolean(int offset, boolean b)
    {
        String inserted = String.valueOf(b);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.insert(offset, b);
            }

            @Override
            public void undo() {
                stringBuilder.delete(offset, offset + inserted.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    public UndoStringBuilder insertChar(int offset, char c)
    {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.insert(offset, c);;
            }

            @Override
            public void undo() {
                stringBuilder.deleteCharAt(offset);
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }

    public UndoStringBuilder insertCharSequence(int dstOffset, CharSequence s)
    {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.insert(dstOffset, s);
            }

            @Override
            public void undo() {
                stringBuilder.delete(dstOffset, dstOffset + s.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
}
