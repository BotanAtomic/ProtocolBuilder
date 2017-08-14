package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.friend.FriendInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class FriendAddedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public FriendInformations friendAdded;
  private FuncTree _friendAddedtree;
  public static final int protocolId = 5599;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.friendAdded.getTypeId());
    this.friendAdded.serialize(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readUnsignedShort();
    this.friendAdded = ProtocolTypeManager.getInstance(FriendInformations, _loc2_);
    this.friendAdded.deserialize(param1);
  }
}
