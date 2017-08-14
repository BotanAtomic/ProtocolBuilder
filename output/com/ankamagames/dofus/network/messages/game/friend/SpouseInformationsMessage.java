package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.friend.FriendSpouseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class SpouseInformationsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public FriendSpouseInformations spouse;
  private FuncTree _spousetree;
  public static final int protocolId = 6356;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.spouse.getTypeId());
    this.spouse.serialize(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readUnsignedShort();
    this.spouse = ProtocolTypeManager.getInstance(FriendSpouseInformations, _loc2_);
    this.spouse.deserialize(param1);
  }
}
