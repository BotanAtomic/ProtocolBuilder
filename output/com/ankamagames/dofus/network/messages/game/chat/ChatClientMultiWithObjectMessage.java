package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatClientMultiWithObjectMessage extends ChatClientMultiMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<ObjectItem> objects;
  private FuncTree _objectstree;
  public static final int protocolId = 862;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.content);

    param1.writeByte(this.channel);

    param1.writeShort(this.objects.length);
    int _loc2_ = 0;
    while (_loc2_ < this.objects.length) {
      ((ObjectItem) this.objects[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    ObjectItem _loc4_ = null;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new ObjectItem();
      _loc4_.deserialize(param1);
      this.objects.push(_loc4_);
      _loc3_++;
    }
  }
}
