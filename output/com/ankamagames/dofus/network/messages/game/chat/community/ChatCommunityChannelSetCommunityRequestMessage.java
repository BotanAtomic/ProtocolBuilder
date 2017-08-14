package com.ankamagames.dofus.network.messages.game.chat.community;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatCommunityChannelSetCommunityRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int communityId = 0;
  public static final int protocolId = 6729;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.communityId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.communityId = param1.readShort();
  }
}
