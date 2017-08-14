package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorDialogQuestionExtendedMessage
    extends TaxCollectorDialogQuestionBasicMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int maxPods = 0;
  public int prospecting = 0;
  public int wisdom = 0;
  public int taxCollectorsCount = 0;
  public int taxCollectorAttack = 0;
  public Number kamas = 0;
  public Number experience = 0;
  public int pods = 0;
  public Number itemsValue = 0;
  public static final int protocolId = 5615;

  @Override
  public void serialize(ICustomDataOutput param1) {
    this.guildInfo.serializeAs_BasicGuildInformations(param1);

    if (this.maxPods < 0) {
      throw new Error("Forbidden value (" + this.maxPods + ") on element maxPods.");
    }
    param1.writeVarShort(this.maxPods);
    if (this.prospecting < 0) {
      throw new Error("Forbidden value (" + this.prospecting + ") on element prospecting.");
    }
    param1.writeVarShort(this.prospecting);
    if (this.wisdom < 0) {
      throw new Error("Forbidden value (" + this.wisdom + ") on element wisdom.");
    }
    param1.writeVarShort(this.wisdom);
    if (this.taxCollectorsCount < 0) {
      throw new Error(
          "Forbidden value (" + this.taxCollectorsCount + ") on element taxCollectorsCount.");
    }
    param1.writeByte(this.taxCollectorsCount);
    param1.writeInt(this.taxCollectorAttack);
    if (this.kamas < 0 || this.kamas > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.kamas + ") on element kamas.");
    }
    param1.writeVarLong(this.kamas);
    if (this.experience < 0 || this.experience > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.experience + ") on element experience.");
    }
    param1.writeVarLong(this.experience);
    if (this.pods < 0) {
      throw new Error("Forbidden value (" + this.pods + ") on element pods.");
    }
    param1.writeVarInt(this.pods);
    if (this.itemsValue < 0 || this.itemsValue > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.itemsValue + ") on element itemsValue.");
    }
    param1.writeVarLong(this.itemsValue);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.maxPods = param1.readVarUhInt();
    if (this.maxPods < 0) {
      throw new Error(
          "Forbidden value (" + this.maxPods + ") on element of MountClientData.maxPods.");
    }

    this.prospecting = param1.readVarUhShort();
    if (this.prospecting < 0) {
      throw new Error(
          "Forbidden value ("
              + this.prospecting
              + ") on element of PartyMemberInformations.prospecting.");
    }

    this.wisdom = param1.readVarUhShort();
    if (this.wisdom < 0) {
      throw new Error(
          "Forbidden value ("
              + this.wisdom
              + ") on element of TaxCollectorDialogQuestionExtendedMessage.wisdom.");
    }

    this.taxCollectorsCount = param1.readByte();
    if (this.taxCollectorsCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.taxCollectorsCount
              + ") on element of GuildInfosUpgradeMessage.taxCollectorsCount.");
    }

    this.taxCollectorAttack = param1.readInt();

    this.kamas = param1.readVarUhLong();
    if (this.kamas < 0 || this.kamas > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.kamas + ") on element of TaxCollectorLootInformations.kamas.");
    }

    this.experience = param1.readVarUhLong();
    if (this.experience < 0 || this.experience > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.experience + ") on element of MountClientData.experience.");
    }

    this.pods = param1.readVarUhInt();
    if (this.pods < 0) {
      throw new Error(
          "Forbidden value (" + this.pods + ") on element of TaxCollectorLootInformations.pods.");
    }

    this.itemsValue = param1.readVarUhLong();
    if (this.itemsValue < 0 || this.itemsValue > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.itemsValue
              + ") on element of TaxCollectorLootInformations.itemsValue.");
    }
  }
}
