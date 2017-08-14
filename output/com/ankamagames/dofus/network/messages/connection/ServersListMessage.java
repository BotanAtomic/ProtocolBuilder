package com.ankamagames.dofus.network.messages.connection;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.connection.GameServerInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ServersListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<GameServerInformations> servers;
  public int alreadyConnectedToServerId = 0;
  public boolean canCreateNewCharacter = false;
  private FuncTree _serverstree;
  public static final int protocolId = 30;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.servers.length);
    int _loc2_ = 0;
    while (_loc2_ < this.servers.length) {
      ((GameServerInformations) this.servers[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    if (this.alreadyConnectedToServerId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.alreadyConnectedToServerId
              + ") on element alreadyConnectedToServerId.");
    }
    param1.writeVarShort(this.alreadyConnectedToServerId);
    param1.writeBoolean(this.canCreateNewCharacter);
  }

  public void deserialize(ICustomDataInput param1) {
    GameServerInformations _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new GameServerInformations();
      _loc4_.deserialize(param1);
      this.servers.push(_loc4_);
      _loc3_++;
    }
    this.alreadyConnectedToServerId = param1.readVarUhShort();
    if (this.alreadyConnectedToServerId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.alreadyConnectedToServerId
              + ") on element of ServersListMessage.alreadyConnectedToServerId.");
    }

    this.canCreateNewCharacter = param1.readBoolean();
  }
}
