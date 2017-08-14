package com.ankamagames.dofus.network.messages.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.quest.QuestActiveInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class QuestStepInfoMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public QuestActiveInformations infos;
  private FuncTree _infostree;
  public static final int protocolId = 5625;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.infos.getTypeId());
    this.infos.serialize(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readUnsignedShort();
    this.infos = ProtocolTypeManager.getInstance(QuestActiveInformations, _loc2_);
    this.infos.deserialize(param1);
  }
}
