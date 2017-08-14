package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareInformations;
import com.ankamagames.dofus.network.types.game.dare.DareVersatileInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareInformationsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public DareInformations dareFixedInfos;
  public DareVersatileInformations dareVersatilesInfos;
  private FuncTree _dareFixedInfostree;
  private FuncTree _dareVersatilesInfostree;
  public static final int protocolId = 6656;

  public void serialize(ICustomDataOutput param1) {
    this.dareFixedInfos.serializeAs_DareInformations(param1);
    this.dareVersatilesInfos.serializeAs_DareVersatileInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.dareFixedInfos = new DareInformations();
    this.dareFixedInfos.deserialize(param1);
    this.dareVersatilesInfos = new DareVersatileInformations();
    this.dareVersatilesInfos.deserialize(param1);
  }
}
