package com.ankamagames.dofus.network.messages.connection;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SelectedServerDataMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int serverId = 0;
  public String address = "";
  public int port = 0;
  public boolean canCreateNewCharacter = false;
  public Vector<Integer> ticket;
  private FuncTree _tickettree;
  public static final int protocolId = 42;

  public void serialize(ICustomDataOutput param1) {
    if (this.serverId < 0) {
      throw new Error("Forbidden value (" + this.serverId + ") on element serverId.");
    }
    param1.writeVarShort(this.serverId);
    param1.writeUTF(this.address);
    if (this.port < 0 || this.port > 65535) {
      throw new Error("Forbidden value (" + this.port + ") on element port.");
    }
    param1.writeShort(this.port);
    param1.writeBoolean(this.canCreateNewCharacter);
    param1.writeVarInt(this.ticket.length);
    int _loc2_ = 0;
    while (_loc2_ < this.ticket.length) {
      param1.writeByte(this.ticket[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = 0;
    this.serverId = param1.readShort();

    this.address = param1.readUTF();

    this.port = param1.readUnsignedShort();
    if (this.port < 0 || this.port > 65535) {
      throw new Error(
          "Forbidden value (" + this.port + ") on element of SelectedServerDataMessage.port.");
    }

    this.canCreateNewCharacter = param1.readBoolean();

    int _loc2_ = param1.readVarInt();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readByte();
      this.ticket.push(_loc4_);
      _loc3_++;
    }
  }
}
