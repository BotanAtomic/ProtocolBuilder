package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FriendsGetListMessage extends NetworkMessage implements INetworkMessage {

  public static final int protocolId = 4001;

  public void serialize(ICustomDataOutput param1) {}

  public void deserialize(ICustomDataInput param1) {}
}
