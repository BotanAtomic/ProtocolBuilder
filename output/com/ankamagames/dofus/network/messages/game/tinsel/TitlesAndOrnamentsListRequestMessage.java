package com.ankamagames.dofus.network.messages.game.tinsel;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TitlesAndOrnamentsListRequestMessage extends NetworkMessage
    implements INetworkMessage {

  public static final int protocolId = 6363;

  public void serialize(ICustomDataOutput param1) {}

  public void deserialize(ICustomDataInput param1) {}
}
