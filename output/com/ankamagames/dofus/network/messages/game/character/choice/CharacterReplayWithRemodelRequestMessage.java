package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.dofus.network.messages.game.character.replay.CharacterReplayRequestMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.RemodelingInformation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterReplayWithRemodelRequestMessage extends CharacterReplayRequestMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public RemodelingInformation remodel;
  private FuncTree _remodeltree;
  public static final int protocolId = 6551;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.characterId < 0 || this.characterId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.characterId + ") on element characterId.");
    }
    param1.writeVarLong(this.characterId);

    this.remodel.serializeAs_RemodelingInformation(param1);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.remodel = new RemodelingInformation();
    this.remodel.deserialize(param1);
  }
}
