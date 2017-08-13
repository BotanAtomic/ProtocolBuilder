package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorBasicInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorAttackedResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5635;
    private boolean _isInitialized = false;
    private boolean deadOrAlive = false;
    private TaxCollectorBasicInformations basicInfos;
    private BasicGuildInformations guild;
    private FuncTree _basicInfostree;
    private FuncTree _guildtree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.deadOrAlive);
         this.basicInfos.serializeAs_TaxCollectorBasicInformations(param1);
         this.guild.serializeAs_BasicGuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deadOrAlive = param1.readBoolean();
         this.basicInfos = new TaxCollectorBasicInformations();
         this.basicInfos.deserialize(param1);
         this.guild = new BasicGuildInformations();
         this.guild.deserialize(param1);
    }

}