package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TaxCollectorDialogQuestionExtendedMessage extends TaxCollectorDialogQuestionBasicMessage implements INetworkMessage {

    private int protocolId = 5615;
    private boolean _isInitialized = false;
    private int maxPods = 0;
    private int prospecting = 0;
    private int wisdom = 0;
    private int taxCollectorsCount = 0;
    private int taxCollectorAttack = 0;
    private Number kamas = 0;
    private Number experience = 0;
    private int pods = 0;
    private Number itemsValue = 0;


    public void serialize(ICustomDataOutput param1) {
         this.guildInfo.serializeAs_BasicGuildInformations(param1);
         if(this.maxPods < 0)
         {
            throw new Exception("Forbidden value (" + this.maxPods + ") on element maxPods.");
         }
         param1.writeVarShort(this.maxPods);
         if(this.prospecting < 0)
         {
            throw new Exception("Forbidden value (" + this.prospecting + ") on element prospecting.");
         }
         param1.writeVarShort(this.prospecting);
         if(this.wisdom < 0)
         {
            throw new Exception("Forbidden value (" + this.wisdom + ") on element wisdom.");
         }
         param1.writeVarShort(this.wisdom);
         if(this.taxCollectorsCount < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorsCount + ") on element taxCollectorsCount.");
         }
         param1.writeByte(this.taxCollectorsCount);
         param1.writeInt(this.taxCollectorAttack);
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element kamas.");
         }
         param1.writeVarLong(this.kamas);
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
         }
         param1.writeVarLong(this.experience);
         if(this.pods < 0)
         {
            throw new Exception("Forbidden value (" + this.pods + ") on element pods.");
         }
         param1.writeVarInt(this.pods);
         if(this.itemsValue < 0 || this.itemsValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.itemsValue + ") on element itemsValue.");
         }
         param1.writeVarLong(this.itemsValue);
    }

    public void deserialize(ICustomDataInput param1) {
         this.guildInfo = new BasicGuildInformations();
         this.guildInfo.deserialize(param1);
         this.maxPods = param1.readVarUhShort();
         if(this.maxPods < 0)
         {
            throw new Exception("Forbidden value (" + this.maxPods + ") on element of TaxCollectorDialogQuestionExtendedMessage.maxPods.");
         }
         this.prospecting = param1.readVarUhShort();
         if(this.prospecting < 0)
         {
            throw new Exception("Forbidden value (" + this.prospecting + ") on element of TaxCollectorDialogQuestionExtendedMessage.prospecting.");
         }
         this.wisdom = param1.readVarUhShort();
         if(this.wisdom < 0)
         {
            throw new Exception("Forbidden value (" + this.wisdom + ") on element of TaxCollectorDialogQuestionExtendedMessage.wisdom.");
         }
         this.taxCollectorsCount = param1.readByte();
         if(this.taxCollectorsCount < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorsCount + ") on element of TaxCollectorDialogQuestionExtendedMessage.taxCollectorsCount.");
         }
         this.taxCollectorAttack = param1.readInt();
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element of TaxCollectorDialogQuestionExtendedMessage.kamas.");
         }
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element of TaxCollectorDialogQuestionExtendedMessage.experience.");
         }
         this.pods = param1.readVarUhInt();
         if(this.pods < 0)
         {
            throw new Exception("Forbidden value (" + this.pods + ") on element of TaxCollectorDialogQuestionExtendedMessage.pods.");
         }
         this.itemsValue = param1.readVarUhLong();
         if(this.itemsValue < 0 || this.itemsValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.itemsValue + ") on element of TaxCollectorDialogQuestionExtendedMessage.itemsValue.");
         }
    }

}