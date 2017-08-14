package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.connection.GameServerInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SelectedServerDataExtendedMessage extends SelectedServerDataMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<GameServerInformations> servers;
  private FuncTree _serverstree;
  public static final int protocolId = 6469;

  @Override
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

    param1.writeShort(this.servers.length);
    int _loc2_ = 0;
    while (_loc2_ < this.servers.length) {
      ((GameServerInformations) this.servers[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    GameServerInformations _loc4_ = null;
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
      _loc4_ = new GameServerInformations();
      _loc4_.deserialize(param1);
      this.servers.push(_loc4_);
      _loc3_++;
    }
  }
}
