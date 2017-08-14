package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CredentialsAcknowledgementMessage extends NetworkMessage implements INetworkMessage {

  public static final int protocolId = 6314;

  public void serialize(ICustomDataOutput param1) {}

  public void deserialize(ICustomDataInput param1) {}
}
