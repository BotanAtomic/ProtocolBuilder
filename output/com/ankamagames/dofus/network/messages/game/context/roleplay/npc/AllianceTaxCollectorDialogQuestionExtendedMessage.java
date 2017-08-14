package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicNamedAllianceInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceTaxCollectorDialogQuestionExtendedMessage
    extends TaxCollectorDialogQuestionExtendedMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public BasicNamedAllianceInformations alliance;
  private FuncTree _alliancetree;
  public static final int protocolId = 6445;

  @Override
  public void serialize(ICustomDataOutput param1) {
    this.guildInfo.serializeAs_BasicGuildInformations(param1);

    if (this.maxPods < 0) {
      throw new Exception("Forbidden value (" + this.maxPods + ") on element maxPods.");
    }
    param1.writeVarShort(this.maxPods);
    if (this.prospecting < 0) {
      throw new Exception("Forbidden value (" + this.prospecting + ") on element prospecting.");
    }
    param1.writeVarShort(this.prospecting);
    if (this.wisdom < 0) {
      throw new Exception("Forbidden value (" + this.wisdom + ") on element wisdom.");
    }
    param1.writeVarShort(this.wisdom);
    if (this.taxCollectorsCount < 0) {
      throw new Exception(
          "Forbidden value (" + this.taxCollectorsCount + ") on element taxCollectorsCount.");
    }
    param1.writeByte(this.taxCollectorsCount);
    param1.writeInt(this.taxCollectorAttack);
    if (this.kamas < 0 || this.kamas > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.kamas + ") on element kamas.");
    }
    param1.writeVarLong(this.kamas);
    if (this.experience < 0 || this.experience > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
    }
    param1.writeVarLong(this.experience);
    if (this.pods < 0) {
      throw new Exception("Forbidden value (" + this.pods + ") on element pods.");
    }
    param1.writeVarInt(this.pods);
    if (this.itemsValue < 0 || this.itemsValue > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.itemsValue + ") on element itemsValue.");
    }
    param1.writeVarLong(this.itemsValue);

    this.alliance.serializeAs_BasicNamedAllianceInformations(param1);
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

    this.alliance = new BasicNamedAllianceInformations();
    this.alliance.deserialize(param1);
  }
}
